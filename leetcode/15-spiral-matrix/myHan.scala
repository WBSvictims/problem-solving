import scala.collection.mutable  

object Solution {
    object Direction {
        def next(dir: (Int, Int)): (Int, Int) = dir match {
            case (0, 1) => (1, 0)
            case (1, 0) => (0, -1)
            case (0, -1) => (-1, 0)
            case _ => (0, 1)
        }
    }
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        val isAlready = Array.ofDim[Boolean](matrix.size, matrix(0).size)
        var (r, c) = (0, 0)
        var dir = (0, 1)
        val ret = mutable.ListBuffer[Int]()
        while(0 <= r && r < matrix.size && 0 <= c && c < matrix(0).size && isAlready(r)(c) != true) {
            isAlready(r)(c) = true
            ret.append(matrix(r)(c))
            
            val ndir = Direction next dir
            val (nr, nc) = (r + dir._1, c + dir._2)
            val (nnr, nnc) = (r + ndir._1, c + ndir._2)
            
            val (xd, (xr, xc)) = if(
                0 <= nr
                && nr < matrix.size
                && 0 <= nc
                && nc < matrix(0).size
                && isAlready(nr)(nc) != true
            ) (dir, (nr, nc)) else (ndir, (nnr, nnc))
            dir = xd
            r = xr
            c = xc
        }
        return ret.toList
    }
}