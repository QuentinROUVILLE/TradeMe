package fr.esgi.quentinrouville.common.infrastructure.memberRepository;

import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.domain.model.member.MemberId;
import fr.esgi.quentinrouville.common.domain.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMemberRepository implements MemberRepository
{
    private static final InMemoryMemberRepository INSTANCE = new InMemoryMemberRepository();
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    public static InMemoryMemberRepository getInstance()
    {
        return INSTANCE;
    }

    @Override
    public void save(Member member)
    {
        data.put(member.getMemberId(), member);
    }

    @Override
    public Member findById(MemberId memberId)
    {
        final Member member = data.get(memberId);

        if (member == null)
        {
            throw new RuntimeException("No member for " + memberId.getValue());
        }
        return member;
    }

    @Override
    public MemberId nextIdentity()
    {
        return MemberId.of(counter.incrementAndGet());
    }

    @Override
    public List<Member> findAll()
    {
        return new ArrayList<>(data.values());
    }
}