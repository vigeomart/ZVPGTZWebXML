<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    Hallgató adatai
                </h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Keresztnév</th>
                        <th>Vezetéknév</th>
                        <th>Foglalkozás</th>
                    </tr>
                    <xsl:for-each select="hallgato/student">
                    <tr>
                        <td><xsl:value-of select="@id"/></td>
                        <td><xsl:value-of select="keresztnev"/></td>
                        <td><xsl:value-of select="vezeteknev"/></td>
                        <td><xsl:value-of select="foglalkozas"/></td>

                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>