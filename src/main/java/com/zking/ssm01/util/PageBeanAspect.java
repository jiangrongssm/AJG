package com.zking.ssm01.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageBeanAspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public  Object invoke(ProceedingJoinPoint args) throws Throwable {

        Object[] params = args.getArgs();
        PageBean pageBean=null;
        for (Object param : params) {
            if (param instanceof PageBean){
                pageBean=(PageBean)param;
            }
        }

        if(null!=pageBean&&pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());


        Object proceed = args.proceed(params);


        if (null!=pageBean&&pageBean.isPagination()){
            List lst=(List)proceed;
            PageInfo pageInfo=new PageInfo(lst);
            System.out.println("当前页码:"+pageInfo.getPageNum());
            System.out.println("每页多少条数据:"+pageInfo.getPageSize());
            System.out.println("总记录数:"+pageInfo.getTotal());

            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return proceed;
    }
}
