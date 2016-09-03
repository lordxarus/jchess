package com.lordxarus.jchess

import com.lordxarus.jchess.board.Board
import com.lordxarus.jchess.piece.PieceAssetStore
import com.lordxarus.jchess.piece.PieceColor
import com.lordxarus.jchess.util.evaluateBoard
import java.awt.Dimension
import javax.swing.JFrame

/**
 * Created by jeremy on 3/10/16.
 */

fun main (args : Array<String>) {

    var boardGui = BoardGui()

    var frame = JFrame()
    frame.add(boardGui)
    frame.addMouseListener(boardGui)
    frame.size = Dimension(514, 540)
    frame.isVisible = true
    frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
    frame.isResizable = false
    frame.title = "JChess"
    frame.iconImage = PieceAssetStore.pieceAssets.get("bkn")

    Board.initBoard()
    println(evaluateBoard(Board.board, PieceColor.BLACK))
    boardGui.repaint()
}
