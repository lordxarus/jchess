package com.lordxarus.jchess.util

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.board.Move
import com.lordxarus.jchess.piece.Piece
import com.lordxarus.jchess.piece.PieceColor

/**
 * Created by jeremy on 3/16/16.
 */

/**
 * @desc evaluates for black
 * **/
fun evaluateBoard(board : Array2D<Piece?>, who2move : PieceColor) : Int {
    var boardValue = 0

    for (i in 0..7) {
        for (j in 0..7) {
            val piece = board.get(i, j)
            if (piece != null) {
                if (piece.color == PieceColor.WHITE) {
                    boardValue -= piece.getPointValue()
                } else {
                    boardValue += piece.getPointValue()
                }
            }
        }
    }
    return boardValue * who2move.getModifier(who2move)
}

fun makeMove(board : Array2D<Piece?>, piece: Piece?, move: Pair<Int?, Int?>) {
    if (piece?.getMoves(board)?.contains(move)!!) {
        val origCoords = piece?.getPosition(board)
        if (origCoords?.first != -1) board[origCoords!!.first, origCoords.second] = null
        board[move.first!!, move.second!!] = piece
    }
}

fun makeMove(board : Array2D<Piece?>, move : Move) {
    board[move.dest!!.first, move.dest.second] = board[move.source!!.first, move.source.second]
    board[move.source.first, move.source.second] = null
}

fun getCoordsByPiece(board : Array2D<Piece?>, candidatePiece : Piece?) : Pair<Int, Int> {
    board.forEachIndexed { i, j, piece ->
        if (piece != null && piece == candidatePiece) {
            return Pair(i, j)
        }
    }
    return Pair(-1, -1)
}

fun cloneBoard(board : Array2D<Piece?>) : Array2D<Piece?> {
    var cloned = Array2D<Piece?>(8, 8)
    board.forEachIndexed { i, j, piece -> cloned[i, j] = board[i, j] }
    return cloned
}
