package com.digitalacademy.loan.service;


import com.digitalacademy.loan.constants.LoanError;
import com.digitalacademy.loan.exception.LoanException;
import com.digitalacademy.loan.model.LoanInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private static final Logger log = LogManager.getLogger(LoanService.class.getName());

    public LoanInfo getLoanInfoByID(Long id) throws Exception{
        log.info("Get loan information by id: {}", id);

        LoanInfo loanInfo = new LoanInfo();
        if(id.equals(1L)) {
            loanInfo.setId(1L);
            loanInfo.setStatus("OK");
            loanInfo.setAccountPayable("102-222-2200");
            loanInfo.setAccountReceivable("102-333-2200");
            loanInfo.setPrincipleAmount(3400000.00);
        } else if(id.equals(2L)){
            log.info("Id: {}", id);
            throw new LoanException(
                    LoanError.GET_LOAN_INFO_NOT_FOUND,
                    HttpStatus.BAD_REQUEST
            );
        }else {
            log.info("id: {}", id);
            throw new Exception("Test throw new exception");
        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1L);
//        map.put("status", "OK");
//        map.put("acountPayable", "102-222-2200");
//        map.put("acountRecievable", "102-333-2200");
//        map.put("principleAmount", 3400000.00);
//        return map;

        return loanInfo;
    }

}
