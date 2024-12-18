package org.lyflexi.debug_springboot.eventdriverprogrammer.subscriber;


import org.lyflexi.debug_springboot.eventdriverprogrammer.LoginSuccessEvent;
import org.lyflexi.debug_springboot.eventdriverprogrammer.UserEntity;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lyflexi
 * @Description
 * @create 2023-04-24 18:44
 */

@Service
public class CouponService {
    public CouponService(){
//        System.out.println("构造器调用");
    }

    @Async
    @Order(1)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        System.out.println("===== CouponService ====感知到事件"+loginSuccessEvent);
        UserEntity source = (UserEntity) loginSuccessEvent.getSource();
        sendCoupon(source.getUsername());
    }

    public void sendCoupon(String username){
        System.out.println(username + " 随机得到了一张优惠券");
    }
}
