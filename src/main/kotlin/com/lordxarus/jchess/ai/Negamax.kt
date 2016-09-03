package com.lordxarus.jchess.ai

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.board.Move
import com.lordxarus.jchess.piece.Piece
import com.lordxarus.jchess.piece.PieceColor
import com.lordxarus.jchess.util.cloneBoard
import com.lordxarus.jchess.util.evaluateBoard
import com.lordxarus.jchess.util.makeMove
import java.util.*

/**
 * Created by jeremy on 3/16/16.
 */
object Negamax  {

    fun getBestMove(board : Array2D<Piece?>, depth : Int) : Move? {
        var bestMove : Move? = null
        var bestScore = Int.MIN_VALUE
        var moves : MutableList<Move> = mutableListOf()
        board.forEach { piece ->
            if (piece?.color != PieceColor.WHITE) {
                piece?.getMoves(board)?.forEach { move ->
                    moves.add(Move(piece.getPosition(board), move))
                }
            }
        }
        moves.forEach { move ->
            var temp = cloneBoard(board)
            makeMove(temp, move)
            var score = -negaMax(temp, depth, PieceColor.WHITE)
            if (score > bestScore) {
                bestScore = score
                bestMove = move
            }
        }

        println(bestScore)
        if (bestScore == 0) {
            val rand = Random()
            bestMove = moves.get(rand.nextInt(moves.size))
        }
        return bestMove
    }

    fun negaMax(board : Array2D<Piece?>, depth : Int, who2move : PieceColor) : Int {
        if (depth == 0) return evaluateBoard(board, who2move)

        var bestScore = Int.MIN_VALUE

        var moves : MutableList<Move> = mutableListOf()
        board.forEach { piece ->
            piece?.getMoves(board)?.forEach { move ->
                moves.add(Move(piece.getPosition(board), move))
            }
        }
        moves.forEach { move ->
            var temp = cloneBoard(board)
            makeMove(temp, move)
            var score = -negaMax(temp, depth - 1, who2move.getOpposite(who2move))
            if (score > bestScore) {
                bestScore = score
            }
        }
        return bestScore
    }
}