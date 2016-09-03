package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.board.Board

/**
 * Created by jeremy on 3/14/16.
 */
class Pawn(override val color: PieceColor) : Piece() {

    override val assetName : String = "p"

    override fun getPointValue(): Int = 1

    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> {

        var moves = emptyList<Pair<Int, Int>>().toMutableList()

        var x = this.getPosition(board).first
        var y = this.getPosition(board).second

        var yMod = this.getYModifier()

        var candX : Int
        var candY : Int

        // Check forward one
        candX = x
        candY = y + (1 * getYModifier())
        if (candY in 0..7 && board[candX, candY] == null) {
            moves.add(Pair(candX, candY))
        }

        // Check forward two
        when {
            this.color == PieceColor.BLACK -> {
                var coords = Pair(x, y + (2 * yMod))
                if (y == 1 && Board.board.get(coords.first, coords.second) == null) {
                    moves.add(coords)
                }
            }
            this.color == PieceColor.WHITE -> {
                var coords = Pair(x, y + (2 * yMod))
                if (y == 6 && Board.board.get(coords.first, coords.second) == null) {
                    moves.add(coords)
                }
            }
        }

        // Check up right attack
        candX = x + 1
        candY = y + (1 * getYModifier())
        // If the space is in bounds
        if (candX in 0..7 && candY in 0..7 && board[candX, candY] != null && board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
        }

        // Check up left attack
        candX = x - 1
        candY = y  + (1 * getYModifier())
        // If the space is in bounds
        if (candX in 0..7 && candY in 0..7 && board[candX, candY] != null && board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
        }

        return moves
    }

}