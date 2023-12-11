package capstone.capstone.service;

import capstone.capstone.domain.ChattingRoom;
import capstone.capstone.domain.Post;
import capstone.capstone.repository.ChattingRoomRepository;
import capstone.capstone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChattingRoomService {
    private final ChattingRoomRepository chattingRoomRepository;

    private final PostRepository postRepository;

    public ChattingRoom createChattingRoom(Integer guestNum, Integer postNum) {
        ChattingRoom chattingRoom = chattingRoomRepository.findByGuestNumAndPostNum(guestNum, postNum);

        if (chattingRoom != null) {
            return chattingRoom;
        }

        Optional<Post> optionalPost = postRepository.findById(postNum);
        ChattingRoom newChattingRoom = new ChattingRoom();

        if (optionalPost.isEmpty()) {
            throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다.");
        }

        Post post = optionalPost.get();
        newChattingRoom.setPostNum(post.getPostNum());
        newChattingRoom.setHostNum(post.getMember().getMemberNum());
        newChattingRoom.setGuestNum(guestNum);

        return chattingRoomRepository.save(newChattingRoom);
    }

    public List<ChattingRoom> findAllChattingRooms() {
        return chattingRoomRepository.findAll();
    }

    public List<ChattingRoom> findAllChattingRoomsByHostNumOrGuestNum(Integer memberNum) {
        return chattingRoomRepository.findAllByHostNumOrGuestNum(memberNum, memberNum);
    }
}