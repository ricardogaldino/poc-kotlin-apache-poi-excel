package poc.apache.poi.excel.presentation.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import poc.apache.poi.excel.domain.interfaces.IReportServce

@RestController
class ReportController(val reportService: IReportServce) {

    @GetMapping("/excel")
    fun getSpreadsheet(): ResponseEntity<ByteArray> {
        val spreadsheet = reportService.generate()

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=poc-apache-poi-excel.xlsx")
            .body(spreadsheet)
    }
}