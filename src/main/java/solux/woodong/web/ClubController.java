package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.dto.club.ClubResponseDto;
import solux.woodong.web.dto.club.ClubSaveRequestDto;
import solux.woodong.web.service.club.ClubService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClubController {
    private final ClubService clubService;

    @PostMapping("/api/udong/club")
    public Long save(@RequestBody ClubSaveRequestDto requestDto) {
        return clubService.save(requestDto);
    }

    @GetMapping("/api/udong/club/{id}")
    public ClubResponseDto findById(@PathVariable Long id) {
        return clubService.findById(id);
    }

    @GetMapping("/api/udong/club")
    public List<Club> getClubList() {
        return clubService.findAll();
    }

    @DeleteMapping("/api/udong/club/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.delete(id);
    }
}
