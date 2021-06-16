package com.siddhartha.SocGenPhase3.ExcelUploader;

//import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelService {
	
	 @Autowired
	 ExcelUploadRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<ExcelFormat> stockRows = ExcelHelper.excelToStockRows(file.getInputStream());
	      repository.saveAll(stockRows);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

//	  public ByteArrayInputStream load() {
//	    List<ExcelFormat> stockRows = repository.findAll();
//
//	    ByteArrayInputStream in = ExcelHelper.stockRowsToExcel(stockRows);
//	    return in;
//	  }

	  public List<ExcelFormat> getAllstockRows() {
	    return repository.findAll();
	  }

}
