<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>
                    ZVPGTZ_órarend
                </h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Tantárgy</th>
                        <th>Típus</th>
                        <th>Nap</th>
                        <th>Kezdés</th>
                        <th>Befejezés</th>
                        <th>Helyszín</th>
                        <th>Oktató</th>
                        <th>Szak</th>
                    </tr>
                    <xsl:for-each select="orarend/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="@tipus"/></td>
                            <td><xsl:value-of select="ido/nap"/></td>
                            <td><xsl:value-of select="ido/tol"/>:00</td>
                            <td><xsl:value-of select="ido/ig"/>:00</td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>