package org.anansy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

public class ImageServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws java.io.IOException {
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        try {
            BufferedImage im = new BufferedImage(640, 120,
                    BufferedImage.TYPE_INT_RGB);

            Random rnd = new Random();

            Color color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            Font font = new Font("Times New Roman", Font.BOLD, 72);

            String text = "You are awesome!";
            Point position = new Point(60, 100);

            Graphics graphics = im.getGraphics();

            graphics.setFont(font);
            graphics.setColor(color);
            graphics.drawString(text, position.x, position.y);

            graphics.dispose();

            ImageIO.write(im, "jpg", out);
        } finally {
            out.close();
        }

    }
}