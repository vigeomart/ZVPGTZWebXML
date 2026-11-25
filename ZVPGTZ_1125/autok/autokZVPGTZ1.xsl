<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="autok">
        <html>
            <head>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>Autók rendszámai</h1>

                <table border="1">
                    <tr>
                        <th>Rendszámok</th>
                        <th>Ár</th>
                    </tr>
                    <xsl:for-each select="auto">
                        <xsl:sort select="ar"/>
                        <tr>
                            <td><xsl:value-of select="@rsz"/></td>
                            <td><xsl:value-of select="ar"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>