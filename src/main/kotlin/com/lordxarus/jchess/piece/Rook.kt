package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.util.getLegalCardinalMoves

/**
 * Created by jeremy on 3/14/16.
 */
class Rook(override val color: PieceColor) : Piece() {
    override val assetName: String = "r"

    override fun getPointValue(): Int = 5

    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> = getLegalCardinalMoves(board, this)
}