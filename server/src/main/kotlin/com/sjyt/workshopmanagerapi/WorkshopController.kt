import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/workshop")
class WorkshopController() {
    @GetMapping
    fun workshop(): String {
        return "Hello world"
    }
}