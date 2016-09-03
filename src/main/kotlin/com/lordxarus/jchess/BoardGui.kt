package com.lordxarus.jchess

import com.lordxarus.jchess.ai.Negamax
import com.lordxarus.jchess.board.Board.board
import com.lordxarus.jchess.piece.Piece
import com.lordxarus.jchess.piece.PieceAssetStore
import com.lordxarus.jchess.piece.PieceColor
import com.lordxarus.jchess.util.makeMove
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JPanel
import javax.swing.SwingUtilities

/**
 * Created by jeremy on 3/10/16.
 */
class BoardGui : JPanel(), MouseListener {
    
    var selectedPiece : Piece? = null
    var turn : PieceColor = PieceColor.WHITE

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        // For smooth text, probably need a better way
        var g2d = g as Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

        // Draw board background
        for (i in 0..7) {
            for (j in 0..7) {
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    g.color = Color(205, 217, 231)
                } else {
                    g.color = Color(106, 154, 106)
                }
                g.fillRect(i * 64, j * 64, 64, 64)
            }
        }

        // Draw background on selected piece's tile
        if (selectedPiece != null) {
            g.color = Color(204, 0, 0, 160)
            var coords = selectedPiece?.getPosition(board)!!
            g.fillRect(coords.first * 64, coords.second * 64, 64, 64)
        }

        // Draw pieces
        board.forEachIndexed { i, j, piece ->
            if (piece?.assetName != null) {
                g.drawImage(PieceAssetStore.pieceAssets["${piece?.color?.colorName}${piece?.assetName}"], (i * 64), (j * 64), this)
            }
        }

        // Draw possible moves, drawn after pieces as to draw over them for visibility
        if (selectedPiece != null) {
            g.color = Color(204, 0, 0, 128)
            selectedPiece?.getMoves(board)?.forEach {
                g.fillOval((it.first * 64) + 16, (it.second * 64) + 16, 32, 32)
            }
        }
        // Drawing coords on tiles
        board.forEachIndexed { i, j, piece ->
            g.color = Color(204, 0, 0)
            g.drawString("($i, $j)", i * 64, (j * 64) + 64)
        }

    }

    override fun mouseEntered(e: MouseEvent?) {
        
    }

    override fun mouseClicked(e: MouseEvent) {
        // The -2 and -26 are to compensate for the fact that clicking in the top left corner yields 2, 26
        var x = (e.x - 2) / 64
        var y = (e.y - 26) / 64

        // Ensure click is in board
        if (x in 0..7 && y in 0..7) {
            // If selecting a piece
            if ((selectedPiece == null || board[x, y] != null) && turn == PieceColor.WHITE && board[x, y]?.color == PieceColor.WHITE) {
                    selectedPiece = board[x, y]
                    repaint()
            // Moving a piece
            } else {
                var coords = Pair(x, y)
                if (selectedPiece?.getPosition(board) != coords) {
                    makeMove(board, selectedPiece as Piece, coords)
                    selectedPiece = null
                    repaint()
                    SwingUtilities.invokeLater { makeMove(board, Negamax.getBestMove(board, 3)!!) }
                    SwingUtilities.invokeLater { turn = PieceColor.WHITE }
                    SwingUtilities.invokeLater { repaint() }
                }

            }
        }

    }

    override fun mouseReleased(e: MouseEvent?) {

    }

    override fun mouseExited(e: MouseEvent?) {
        
    }

    override fun mousePressed(e: MouseEvent?) {
        
    }


}
