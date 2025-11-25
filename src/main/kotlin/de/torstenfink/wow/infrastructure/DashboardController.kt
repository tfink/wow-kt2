package de.torstenfink.wow.infrastructure

import de.torstenfink.wow.application.DashboardQuery
import de.torstenfink.wow.application.DashboardResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DashboardController(
    private val dashboardQuery: DashboardQuery
) {
    @GetMapping("/", produces = ["application/json"])
    fun dashboard(model: Model): DashboardResponse {
        val dashboardResponse = dashboardQuery.execute()
        model.addAttribute("dashboard", dashboardResponse)
        return dashboardResponse
    }
}