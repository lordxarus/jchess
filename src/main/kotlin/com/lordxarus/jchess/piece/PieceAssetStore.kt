package com.lordxarus.jchess.piece

import javax.imageio.ImageIO

/**
 * Created by jeremy on 3/13/16.
 */
object PieceAssetStore {

    val pieceAssets = hashMapOf(
            Pair("bb", ImageIO.read(javaClass.getResourceAsStream("/pieces/bb.png"))),
            Pair("bk", ImageIO.read(javaClass.getResourceAsStream("/pieces/bk.png"))),
            Pair("bkn", ImageIO.read(javaClass.getResourceAsStream("/pieces/bkn.png"))),
            Pair("bp", ImageIO.read(javaClass.getResourceAsStream("/pieces/bp.png"))),
            Pair("bq", ImageIO.read(javaClass.getResourceAsStream("/pieces/bq.png"))),
            Pair("br", ImageIO.read(javaClass.getResourceAsStream("/pieces/br.png"))),
            Pair("wb", ImageIO.read(javaClass.getResourceAsStream("/pieces/wb.png"))),
            Pair("wk", ImageIO.read(javaClass.getResourceAsStream("/pieces/wk.png"))),
            Pair("wkn", ImageIO.read(javaClass.getResourceAsStream("/pieces/wkn.png"))),
            Pair("wp", ImageIO.read(javaClass.getResourceAsStream("/pieces/wp.png"))),
            Pair("wb", ImageIO.read(javaClass.getResourceAsStream("/pieces/wb.png"))),
            Pair("wq", ImageIO.read(javaClass.getResourceAsStream("/pieces/wq.png"))),
            Pair("wr", ImageIO.read(javaClass.getResourceAsStream("/pieces/wr.png")))
    )

}