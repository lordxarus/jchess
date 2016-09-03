package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.util.getLegalCardinalMoves
import com.lordxarus.jchess.util.getLegalDiagonalMoves

/**
 * Created by jeremy on 3/14/16.
 */
class Queen(override val color: PieceColor) : Piece() {

    override val assetName: String = "q"

    override fun getPointValue(): Int = 9

    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> {

        var moves = emptyList<Pair<Int, Int>>().toMutableList()

        moves.addAll(getLegalCardinalMoves(board, this))
        moves.addAll(getLegalDiagonalMoves(board, this))

        return moves
    }


}