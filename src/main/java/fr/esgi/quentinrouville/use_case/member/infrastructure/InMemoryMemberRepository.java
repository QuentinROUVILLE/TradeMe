package fr.esgi.quentinrouville.use_case.member.infrastructure;

import fr.esgi.quentinrouville.use_case.error.infrastructure.FindMemberException;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
    public Member findById(MemberId memberId) throws NoSuchElementException
    {
        final Member member = data.get(memberId);

        if (member == null)
        {
            throw new FindMemberException(memberId.getValue());
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
        return List.copyOf(data.values());
    }
}