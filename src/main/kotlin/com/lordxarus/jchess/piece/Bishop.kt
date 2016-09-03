package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.util.getLegalDiagonalMoves

/**
 * Created by jeremy on 3/14/16.
 */
class Bishop(override val color: PieceColor) : Piece() {
    override val assetName: String = "b"

    override fun getPointValue(): Int = 3

    override fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>> = getLegalDiagonalMoves(board, this)
}