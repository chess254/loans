package com.pezesha.loans.controller.web;

import com.pezesha.loans.util.LoanRepaymentCalculator;
import com.pezesha.loans.util.LoanRepaymentSchedule;
import com.pezesha.loans.util.RepaymentFrequency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class LoanController {

    @GetMapping("/form")
    public String showLoanForm(){
        return "loanForm";
    }


    @PostMapping(value = "/calculate", consumes = "application/x-www-form-urlencoded")
    public String index(@RequestParam("loanAmount") double loanAmount,
                        @RequestParam("loanTermMonths") int loanTermMonths,
                        @RequestParam("interestRate") double interestRate,
                        @RequestParam("repaymentFrequency") int repaymentFrequency,
                        Model model){
        int rf;
        switch (repaymentFrequency) {
            case 12:
                rf = 0;
                break;
            case 6:
                rf = 1;
                break;
            default:
                rf = 2;
        }
        RepaymentFrequency freq = RepaymentFrequency.values()[rf];
        LoanRepaymentCalculator calculator = new LoanRepaymentCalculator();
//        String response = calculator.calculateRepaymentSchedule(
//                loanAmount,
//                loanTermMonths,
//                interestRate,
//                freq
//        ).toString();
        LoanRepaymentSchedule response = calculator.calculateRepaymentSchedule(
                loanAmount,
                loanTermMonths,
                interestRate,
                freq
        );

        log.info("response: {}", response);

//        JSONObject data = new JSONObject(response);
        model.addAttribute("loanRepaymentSchedule", response);
        return "index";

    }
}
