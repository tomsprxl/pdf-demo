package com.example.pdfdemo.controller;

import com.example.pdfdemo.dao.PDFData;
import com.example.pdfdemo.pdftemplateenum.PdfTemplateEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:
 *
 * @author xuliang
 * @create 2019-09-02 13:58
 */
@RestController
public class PDFDemoController {


    @RequestMapping("/getHtml")
    public void getHtml(HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        String pdfstr = getPdfStr(PdfTemplateEnum.TEMPLATE_ENUM1.getMemo());
        sb.append(pdfstr);
        sb.append("</body>\n" +
                "</html>");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(sb.toString());
    }

    /**
     * 去除空格
     *
     * @param pdfstr
     * @return
     */
    private String getPdfStr(String pdfstr) {
        pdfstr.replace("\\n\"+\"", "");
        pdfstr = replaceData(pdfstr);
        return pdfstr;
    }

    /**
     * 填充数据
     *
     * @param dest
     * @return
     */
    private String replaceData(String dest) {
        PDFData pdfData = new PDFData();
        pdfData.setContract_number("HT201908271034412880");
        pdfData.setSign_address("上海浦东");
        pdfData.setSign_time("2019-08-27");
        pdfData.setCustomers_name("舒宝");
        pdfData.setBuyer_phone("15618610895");
        pdfData.setBuyer_contract_name("舒宝");
        pdfData.setGood_tons("吨");
        pdfData.setGood_name("北京,汇福,43%,50kg");
        pdfData.setGood_num("10");
        pdfData.setGood_price("2000");
        pdfData.setContract_total_price("20000.00");
        pdfData.setContract_remark("10:34");
        pdfData.setRmb("贰万元整");
        pdfData.setEgg_attr("43%");
        pdfData.setCash_money("2000.00");
        pdfData.setDelivery_start_time("2019-08-27");
        pdfData.setDelivery_end_time("2019-08-31");
        pdfData.setDelivery_address("北京汇福油厂");
        pdfData.setCustomer_payments_name("");
        pdfData.setCustomer_payments_china_id("");
//        private String contract_number;//合同编号
//        private String sign_address;
//        private String sign_time;
//        private String customers_name;//甲方名称
//        private String buyer_phone;
//        private String buyer_contract_name;
//        private String good_tons; //good_unit
//        private String good_name;
//        private String good_num;
//        private String good_price;
//        private String contract_total_price;
//        private String contract_remark;
//        private String rmb;
//        private String egg_attr;
//        private String cash_money;
//        private String delivery_start_time;
//        private String delivery_end_time;
//        private String delivery_address;
//        private String customer_payments_name;
//        private String customer_payments_china_id;
        dest.replace("#contract_number#",pdfData.getContract_number());
        dest.replace("#sign_address#",pdfData.getSign_address());
        dest.replace("#sign_time#",pdfData.getSign_time());
        dest.replace("#contract_number#",pdfData.getContract_number());
        dest.replace("#contract_number#",pdfData.getContract_number());
        dest.replace("#contract_number#",pdfData.getContract_number());


        return dest;
    }


}