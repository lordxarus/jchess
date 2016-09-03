package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D

/**
 * Created by jeremy on 3/14/16.
 */
class Knight(override val color: PieceColor) : Piece() {

    override val assetName: String = "kn"

    override fun getPointValue(): Int = 3

    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> {

        var moves = emptyList<Pair<Int, Int>>().toMutableList()

        var x = this.getPosition(board).first
        var y = this.getPosition(board).second

        var yMod = this.getYModifier()

        var candX : Int
        var candY : Int

        candX = x - 1
        candY = y + (2 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x + 1
        candY = y + (2 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x - 2
        candY = y + (1 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x + 2
        candY = y + (1 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x - 1
        candY = y - (2 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x + 1
        candY = y - (2 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x - 2
        candY = y - (1 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        candX = x + 2
        candY = y - (1 * yMod)
        if (candX in 0..7 && candY in 0..7) {
            if (board[candX, candY] == null || board[candX, candY]?.color != this.color) {
                moves.add(Pair(candX, candY))
            }
        }

        return moves
    }
}
