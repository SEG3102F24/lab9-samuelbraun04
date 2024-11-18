

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.PrintWriter
import java.io.StringWriter

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception): ResponseEntity<String> {
        
        ex.printStackTrace()

        
        val sw = StringWriter()
        ex.printStackTrace(PrintWriter(sw))
        val exceptionAsString = sw.toString()

        
        val errorMessage = "An error occurred: ${ex.message}\n\n$exceptionAsString"

        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
