package de.scholzf.javapoly.Entity.GameObjects;


import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.TileBase;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.TileType;
import de.scholzf.javapoly.Entity.base.EntityFigure;
import de.scholzf.javapoly.Entity.base.GameObjectType;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Semaphore;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameObject extends Game implements TileBase
{

    public TileType type;
    public String name;
    public List<Entity> entities;
    public GameObjectType gameObjectType;
    public EntityFigure entityFigure;
    public double money;
    public Jail jail;

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public TileType getTileType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setEntity(Entity entity) {
        this.entities.add(entity);
    }

    public static class Canvas extends JPanel
    {
        private static Canvas instance;

        private final int cellWidth;

        private final int cellHeight;

        private final Set<GameObject> gameObjects = new TreeSet<>(
                (a, b) -> {
                    final int aDepth = a.getX() + a.getY();
                    final int bDepth = b.getX() + b.getY();
                    return aDepth == bDepth ? a.id - b.id : aDepth - bDepth;
                });

        private final Semaphore waitForKey = new Semaphore(0);

        private final Queue<Integer> keys = new LinkedList<>();

        public static Canvas getInstance()
        {
            if (instance == null) {
                instance = new Canvas(1980, 1020, 180, 90);
            }
            return instance;
        }

        public Canvas(final int canvasWidth, final int canvasHeight,
                      final int cellWidth, final int cellHeight)
        {
            instance = this;
            this.cellWidth = cellWidth;
            this.cellHeight = cellHeight;
            final JFrame frame = new JFrame("JavaPoly");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(this);
            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(final KeyEvent event) {
                    synchronized (keys) {
                        keys.offer(event.getKeyCode());
                    }
                    waitForKey.release();
                }
            });
            setPreferredSize(new Dimension(canvasWidth, canvasHeight));
            frame.pack();
            frame.setVisible(true);
        }


        public int getNextKey()
        {
            try {
                waitForKey.acquire();
                synchronized (keys) {
                    return keys.poll();
                }
            }
            catch (final InterruptedException e) {
                // Abbruch während des Wartens auf Taste: So tun als ob ESC gedrückt.
                return KeyEvent.VK_ESCAPE;
            }
        }

        @Override
        public void paintComponent(final Graphics graphics)
        {
            // Hintergrund neu zeichnen
            super.paintComponent(graphics);

            // Alle Spielobjekte zeichnen
            synchronized (this) {
                for (final GameObject gameObject : gameObjects) {
                    final Rectangle drawRectangle = getDrawRectangle(gameObject);
                    graphics.drawImage(gameObject.getImage(),
                            (int) drawRectangle.getX(), (int) drawRectangle.getY(),
                            null);
                }
            }
        }

        private void addObject(final GameObject gameObject)
        {
            synchronized (this) {
                if (!gameObject.isVisible()) {
                    gameObject.id = nextId++;
                    gameObjects.add(gameObject);
                    repaintObject(gameObject);
                }
            }
        }

        private boolean removeObject(final GameObject gameObject)
        {
            synchronized (this) {
                final boolean removed = gameObjects.remove(gameObject);
                repaintObject(gameObject);
                return removed;
            }
        }

        private boolean containsObject(final GameObject gameObject)
        {
            return gameObjects.contains(gameObject);
        }

        private void repaintObject(final GameObject gameObject)
        {
            repaint(getDrawRectangle(gameObject));
        }

        private Rectangle getDrawRectangle(final GameObject gameObject)
        {
            final int xOrigin = getWidth() / 2;
            final int yOrigin = (getHeight() % cellHeight + cellHeight) / 2;
            final int x = xOrigin + (gameObject.getX() - gameObject.getY())
                    * cellWidth / 2 - gameObject.getImage().getWidth() / 2;
            final int y = yOrigin + ((gameObject.getX() + gameObject.getY())
                    * cellHeight) / 2 - gameObject.getImage().getHeight() / 2;
            return new Rectangle(x, y, gameObject.getImage().getWidth(),
                    gameObject.getImage().getHeight());
        }
    }

    private static final Map<String, BufferedImage> bufferedImages = new HashMap<>();

    private static int nextId = 1;

    private int id;

    private int x;

    private int y;

    private int rotation;

    private String imageFileName;

    private String objectName;

    private BufferedImage image;

    public GameObject(TileType type, int x, int y, String fileName){
        this(x, y, 0, fileName);
        this.type = type;
    }

    public GameObject(TileType type, String fileName){
        this(0, 0, 0, fileName);
        this.type = type;
    }

    public GameObject(TileType type, String objectName, String fileName){
        this(0, 0, 0, fileName);
        this.type = type;
        this.objectName = objectName;
    }

    public GameObject(String name, GameObjectType type, EntityFigure figure, double money, Jail jail) {
        this.name = name;
        this.gameObjectType = type;
        this.entityFigure = figure;
        this.money = money;
        this.jail = jail;
    }

    public GameObject(String objectName, int x, int y, int rotation, String fileName, double money, GameObjectType type, EntityFigure figure, Jail jail){
       this(x, y, rotation, fileName);
       this.objectName = objectName;
       this.money = money;
       this.gameObjectType = type;
       this.entityFigure = figure;
       this.jail = jail;
    }

    public GameObject(final int x, final int y, int rotation, final String fileName)
    {
        this.x = x;
        this.y = y;
        this.rotation = rotation & 3;
        setImage(fileName);
        setVisible(true);
    }

    public GameObject(final int x, final int y, String fileName) {
        this(x, y, 0, fileName);
    }

    public GameObject(final int x, final int y, final BufferedImage image)
    {
        this.x = x;
        this.y = y;
        setImage(image);
        setVisible(true);
    }

    public void setLocation(final int x, final int y)
    {
        final boolean removed = Canvas.getInstance().removeObject(this);
        this.x = x;
        this.y = y;
        if (removed) {
            Canvas.getInstance().addObject(this);
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setRotation(final int rotation)
    {
        // Alten Wert für Vergleich merken.
        final int prevRotation = this.rotation;

        // In Bereich 0..3 bewegen und übernehmen.
        this.rotation = rotation & 3;

        // Bild bei Bedarf an Orientierung anpassen.
        if (imageFileName != null && this.rotation != prevRotation) {
            setImage(imageFileName);
        }
    }

    public int getRotation()
    {
        return rotation;
    }

    public void setImage(final String fileName)
    {
        // Dateinamen in Teile vor und nach dem Punkt zerlegen.
        final int period = fileName.lastIndexOf('.');
        final int separator = fileName.lastIndexOf(File.separator);
        final String baseName;
        final String extension;

        // Punkt hinter letztem Pfadtrenner gefunden?
        if (period > separator) {
            baseName = fileName.substring(0, period);
            extension = fileName.substring(period);
        }
        else {
            baseName = fileName;
            extension = ".png";
        }

        // Bild aus Cache verwenden
        BufferedImage image = bufferedImages.get(baseName + "-" + rotation + extension);

        // Wenn nicht gefunden, dann Datei laden
        if (image == null) {
            try {
                // Zuerst mit Orientierung versuchen.
                image = ImageIO.read(new File("images" + File.separator + baseName
                        + "-" + rotation + extension));
            }
            catch (final IOException e1) {
                // Ansonsten ohne Orientierung versuchen.
                try {
                    image = ImageIO.read(new File("images" + File.separator
                            + baseName + extension));
                }
                catch (final IOException e2) {
                    throw new IllegalArgumentException("Die Bilddatei '"
                            + baseName + extension
                            + "' konnte nicht geladen werden.");
                }
            }

            // Überprüfen, ob ein Bild geladen wurde.
            if (image == null) {
                throw new IllegalArgumentException("Die Datei '" + baseName
                        + extension + "' enthält kein Bild.");
            }

            // Geladenes Bild im Cache speichern.
            bufferedImages.put(baseName + "-" + rotation + extension, image);
        }

        // Bild setzen
        setImage(image);

        // Dateinamen übernehmen.
        imageFileName = fileName;
    }

    public void setImage(final BufferedImage image)
    {
        // Das Bild muss existieren, sonst kommt es beim Zeichnen zum Fehler.
        if (image == null) {
            throw new NullPointerException("Das Bild darf nicht 'null' sein.");
        }

        Rectangle drawRectangle = this.image != null
                ? Canvas.getInstance().getDrawRectangle(this) : new Rectangle(x, y, 0, 0);

        this.image = image;
        imageFileName = null;

        if (isVisible()) {
            drawRectangle.add(Canvas.getInstance().getDrawRectangle(this));
            Canvas.getInstance().repaint(drawRectangle);
        }
    }

    private BufferedImage getImage()
    {
        return image;
    }

    public void setVisible(final boolean visible)
    {
        if (visible) {
            Canvas.getInstance().addObject(this);
        }
        else {
            Canvas.getInstance().removeObject(this);
        }
    }

    public boolean isVisible()
    {
        return Canvas.getInstance().containsObject(this);
    }
}