package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D

/**
 * Created by jeremy on 3/13/16.
 */
class King(override val color: PieceColor) : Piece() {
    override var assetName : String = "k"

    override fun getPointValue(): Int = 100


    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> {
        var moves = emptyList<Pair<Int, Int>>().toMutableList()

        var x = this.getPosition(board).first
        var y = this.getPosition(board).second

        for (i in -1..1) {
            for (j in -1..1) {
                var candX = x + i
                var candY = y + j
                if (candX in 0..7 && candY in 0..7 && board[candX, candY]?.color != this.color) {
                    moves.add(Pair(candX, candY))
                }
            }
        }
        return moves
    }

}