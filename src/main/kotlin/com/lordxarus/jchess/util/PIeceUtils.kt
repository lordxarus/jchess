package com.lordxarus.jchess.util

import com.lordxarus.jchess.board.Array2D
import com.lordxarus.jchess.piece.Piece

/**
 * Created by jeremy on 3/16/16.
 */

/**
 * Gets all moves that are diagonal from the given piece
 * @param board the board to operate on
 * @param piece the piece to get diagonals from
 * @return list of diagonal moves
 * **/
fun getLegalDiagonalMoves(board : Array2D<Piece?>, piece : Piece) : List<Pair<Int, Int>> {

    var moves = emptyList<Pair<Int, Int>>().toMutableList()

    var x = piece.getPosition(board).first
    var y = piece.getPosition(board).second

    var candX : Int
    var candY : Int

    for (i in 1..7) {
        candX = x + i
        candY = y + i

        if (candX in 0..7 && candY in 0..7 && (candX + candY) % 2 == (x + y) % 2) {
            if (board[candX, candY] == null) {
                moves.add(Pair(candX, candY))
            } else {
                if (board[candX, candY]?.color != piece.color) moves.add(Pair(candX, candY))
                break
            }
        }
    }

    for (i in 1..7) {
        candX = x - i
        candY = y - i

        if (candX in 0..7 && candY in 0..7 && (candX + candY) % 2 == (x + y) % 2) {
            if (board[candX, candY] == null) {
                moves.add(Pair(candX, candY))
            } else {
                if (board[candX, candY]?.color != piece.color) moves.add(Pair(candX, candY))
                break
            }
        }
    }

    for (i in 1..7) {
        candX = x + i
        candY = y - i

        if (candX in 0..7 && candY in 0..7 && (candX + candY) % 2 == (x + y) % 2) {
            if (board[candX, candY] == null) {
                moves.add(Pair(candX, candY))
            } else {
                if (board[candX, candY]?.color != piece.color) moves.add(Pair(candX, candY))
                break
            }
        }
    }

    for (i in 1..7) {
        candX = x - i
        candY = y + i

        if (candX in 0..7 && candY in 0..7 && (candX + candY) % 2 == (x + y) % 2) {
            if (board[candX, candY] == null) {
                moves.add(Pair(candX, candY))
            } else {
                if (board[candX, candY]?.color != piece.color) moves.add(Pair(candX, candY))
                break
            }
        }
    }

    return moves
}

/**
 * Get all legal moves in the four cardinal directions
 * @param
 * **/
fun getLegalCardinalMoves(board : Array2D<Piece?>, piece : Piece) : List<Pair<Int, Int>> {

    var moves = emptyList<Pair<Int, Int>>().toMutableList()

    var x = piece.getPosition(board).first
    var y = piece.getPosition(board).second

    var yMod = piece.getYModifier()

    // Each direction is separated to make quiting on finding a piece in the way easier

    // Up
    for (i in 1..7) {
        if (y + (i * yMod) in 0..7) {
            if (board[x, y + (i * yMod)] == null) {
                moves.add(Pair(x, y + (i * yMod)))
            } else {
                if (board[x, y + (i * yMod)]?.color != piece.color) moves.add(Pair(x, y + (i * yMod)))
                break
            }
        }
    }

    // Down
    for (i in 1..7) {
        if (y - (i * yMod) in 0..7) {
            if (board[x, y - (i * yMod)] == null) {
                moves.add(Pair(x, y - (i * yMod)))
            } else {
                if (board[x, y - (i * yMod)]?.color != piece.color) moves.add(Pair(x, y - (i * yMod)))
                break
            }
        }
    }

    // Left
    for (i in 1..7) {
        if (x - i in 0..7) {
            if (board[x - i, y] == null) {
                moves.add(Pair(x - i, y))
            } else {
                if (board[x - i, y]?.color != piece.color) moves.add((Pair(x - i, y)))
                break
            }
        }
    }

    // Right
    for (i in 1..7) {
        if (x + i in 0..7) {
            if (board[x + i, y] == null) {
                moves.add(Pair(x + i, y))
            } else {
                if (board[x + i, y]?.color != piece.color) moves.add((Pair(x + i, y)))
                break
            }
        }
    }

    return moves
}