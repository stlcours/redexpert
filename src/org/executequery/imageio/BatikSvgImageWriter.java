/*
 * BatikSvgImageWriter.java
 *
 * Copyright (C) 2002-2017 Takis Diakoumis
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.executequery.imageio;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.geom.AffineTransform;
import java.io.*;

public class BatikSvgImageWriter extends AbstractImageWriter {

    public void write(ImageWriterInfo imageWriterInfo) {

        if (!(imageWriterInfo instanceof SvgImageWriterInfo)) {

            throw new IllegalArgumentException(
                    "Image writer info must be an instance of SvgImageWriterInfo");
        }

        SvgImageWriterInfo svgImageWriterInfo = (SvgImageWriterInfo) imageWriterInfo;

        DOMImplementation domImpl =
                GenericDOMImplementation.getDOMImplementation();

        Document document = domImpl.createDocument(null, "svg", null);

        SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(document);
        ctx.setComment("Generated by Red Expert with Batik SVG Generator");

        SVGGraphics2D svgGraphics = new SVGGraphics2D(
                ctx, svgImageWriterInfo.isRenderFontsAsImages());
        svgGraphics.drawImage(svgImageWriterInfo.getBufferedImage(),
                new AffineTransform(1f, 0f, 0f, 1f, 0, 0), null);

        Writer out = null;
        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(svgImageWriterInfo.getWriteToFile());

            out = new OutputStreamWriter(fos, "UTF-8");
            svgGraphics.stream(out, true);

            fos.flush();

        } catch (FileNotFoundException e) {

            handleException(e);

        } catch (UnsupportedEncodingException e) {

            handleException(e);

        } catch (SVGGraphics2DIOException e) {

            handleException(e);

        } catch (IOException e) {

            handleException(e);

        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }

            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                }

            }

        }

    }

}







