<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:key name="varos-kulcs" match="auto" use="tulaj/varos"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Autók statisztikája városonként</title>
            </head>
            <body>
                <h2>Autók darabszáma és összára városonként</h2>
                <table border="1">
                    <tr>
                        <th>Város</th>
                        <th>Darabszám (db)</th>
                        <th>Összár (Ft)</th>
                    </tr>
                    
                    <xsl:for-each select="autok/auto[generate-id() = generate-id(key('varos-kulcs', tulaj/varos)[1])]">
                        <xsl:sort select="tulaj/varos" order="ascending"/>
                        <tr>
                            <td><xsl:value-of select="tulaj/varos"/></td>
                            <td><xsl:value-of select="count(key('varos-kulcs', tulaj/varos))"/></td>
                            <td><xsl:value-of select="sum(key('varos-kulcs', tulaj/varos)/ar)"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>