package hello.core.order;

import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.FIxDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByById(memberId);
        int discountPrice = discountPolicy.dicount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
