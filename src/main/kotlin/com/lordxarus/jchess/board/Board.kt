package com.lordxarus.jchess.board

import com.lordxarus.jchess.piece.*

import com.lordxarus.jchess.piece.PieceColor.BLACK
import com.lordxarus.jchess.piece.PieceColor.WHITE
/**
 * Created by jeremy on 3/13/16.
 */
object Board {

    var board = Array2D<Piece>(8, 8)

    fun initBoard () {
        // Place black pawns
        for (i in 0..7) {
            board[i, 1] = Pawn(BLACK)
        }

        // Place white pawns
        for (i in 0..7) {
            board[i, 6] = Pawn(WHITE)
        }

        // Rooks
        board[0, 0] = Rook(BLACK)
        board[7, 0] = Rook(BLACK)
        board[0, 7] = Rook(WHITE)
        board[7, 7] = Rook(WHITE)

        // Knights
        board[1, 0] = Knight(BLACK)
        board[6, 0] = Knight(BLACK)
        board[1, 7] = Knight(WHITE)
        board[6, 7] = Knight(WHITE)

        // Bishops
        board[2, 0] = Bishop(BLACK)
        board[5, 0] = Bishop(BLACK)
        board[2, 7] = Bishop(WHITE)
        board[5, 7] = Bishop(WHITE)

        // Queens
        board[3, 0] = Queen(BLACK)
        board[3, 7] = Queen(WHITE)

        // Kings
        board[4, 0] = King(BLACK)
        board[4, 7] = King(WHITE)

    }

}

