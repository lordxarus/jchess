package com.lordxarus.jchess.piece

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.piece.PieceColor.BLACK
import com.lordxarus.jchess.piece.PieceColor.WHITE
import com.lordxarus.jchess.util.getCoordsByPiece

/**
 * Created by jeremy on 3/13/16.
 */
abstract class Piece() {

    /**
     * Represents the color of this piece
     * **/
    abstract val color : PieceColor

    /**
     * Uses [color] and this to get the image for this piece from [PieceAssetStore]
     * **/
    abstract val assetName : String

    /**
     * @return the value of the piece
     * **/
    abstract fun getPointValue() : Int

    /**
     * Gets all of the valid moves this piece can move. Including the moves that result in a capture.
     * @param board the board that the piece is on
     * @return all of the moves the piece can make
     * **/
    abstract fun getMoves(board: Array2D<Piece?>): List<Pair<Int, Int>>

    /**
     * Uses [Board.getCoordsByPiece] to find the coords of this piece
     * */
    fun getPosition(board : Array2D<Piece?>): Pair<Int, Int> {
        return getCoordsByPiece(board, this)
    }

    /**
     * Since black's moves advance with a +1 and white advances with a -1 this function decides which to use based on the [color]
     * @return modifier returns -1 for white, +1 for black, and 0 zero if something is very wrong
     *
     * **/
    fun getYModifier(): Int {
        when {
            color == WHITE -> return -1
            color == BLACK -> return  1
        }
        return 0
    }

}