<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:key name="auto-kulcs" match="auto" use="tipus"/>
    <xsl:template match="autok">
        <html>
            <head>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>Autók rendszámai</h1>

                <table border="1">
                    <tr>
                        <th>Típusok</th>
                        <th>Darabszámok</th>
                    </tr>
                    <xsl:for-each select="auto[generate-id() = generate-id(key('auto-kulcs',tipus)[1])]">
                        <xsl:sort select="count(key('auto-kulcs',tipus))" data-type="number" order="ascending"/>
                    
                    <tr>
                            <td><xsl:value-of select="tipus"/></td>
                            <td><xsl:value-of select="count(key('auto-kulcs', tipus))"/></td>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>