package y2021.m03.d14

class LC489RobotRoomCleaner {

    // This is the Robot's API interface.
    // You should not implement it, or speculate about its implementation
    class Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        fun move(): Boolean {return true}

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        fun turnLeft() {}
        fun turnRight() {}

        // Clean the current cell.
        fun clean() {}
    }

    class Solution {
        // always turn to N after every action

        fun cleanRoom(robot: Robot) {
            with (robot) {
                clean()
                if (getNeighborPos(Dir.UP) !in visited && moveTo(Dir.UP)) {
                    cleanRoom(robot)
                    moveTo(Dir.DOWN)
                }
                if (getNeighborPos(Dir.DOWN) !in visited && moveTo(Dir.DOWN)) {
                    cleanRoom(robot)
                    moveTo(Dir.UP)
                }
                if (getNeighborPos(Dir.LEFT) !in visited && moveTo(Dir.LEFT)) {
                    cleanRoom(robot)
                    moveTo(Dir.RIGHT)
                }
                if (getNeighborPos(Dir.RIGHT) !in visited && moveTo(Dir.RIGHT)) {
                    cleanRoom(robot)
                    moveTo(Dir.LEFT)
                }
            }
        }

        enum class Dir(val code: Int) { UP(1), RIGHT(2), DOWN(3), LEFT(4) }

        var dir = Dir.UP
        var x = 0
        var y = 0
        val visited = mutableSetOf<Pair<Int,Int>>(0 to 0)

        tailrec fun Robot.turn(to: Dir) {
            if (to == dir) return
            turnRight()
            dir = when (dir) {
                Dir.UP -> Dir.RIGHT
                Dir.RIGHT -> Dir.DOWN
                Dir.DOWN -> Dir.LEFT
                Dir.LEFT -> Dir.UP
            }
            turn(to)
        }

        fun Robot.moveTo(to: Dir): Boolean {
            turn(to)
            val nextPos = getNeighborPos(dir)
            visited += nextPos
            val moveSuccess = move()
            if (moveSuccess) {
                x = nextPos.first
                y = nextPos.second
            }
            return moveSuccess
        }

        fun getNeighborPos(dir: Dir): Pair<Int,Int> = when (dir) {
            Dir.UP -> x to y - 1
            Dir.RIGHT -> x + 1 to y
            Dir.DOWN -> x to y + 1
            Dir.LEFT -> x - 1 to y
        }
    }
}
