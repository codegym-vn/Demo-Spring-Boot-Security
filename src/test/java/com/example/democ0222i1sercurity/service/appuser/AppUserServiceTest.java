package com.example.democ0222i1sercurity.service.appuser;

import com.example.democ0222i1sercurity.model.AppUser;
import com.example.democ0222i1sercurity.repo.AppUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppUserServiceTest {

    private AppUserRepo appUserRepo = Mockito.mock(AppUserRepo.class);
    private IAppUserService appUserService = new AppUserService(appUserRepo);

    @BeforeEach
    void init(){
        AppUser appUser = new AppUser(1L, "KA", "12345", "ka@gmail.com");
        List<AppUser> appUserList = Arrays.asList(appUser);
        doReturn(appUserList).when(appUserRepo).findAll();
        doReturn(Optional.of(appUser)).when(appUserRepo).findById(1L);
    }


    @Test
    @DisplayName("findAll can return list not null")
    public void whenFindAllReturnNotNull(){
//        AAA
//        A: Arrange: chuẩn bị dữ liệu để gọi phương thức, dữ liệu đầu vào và kết quả kỳ vọng

//        A: Action: gọi phương thức
//        A: Assert: so sánh kết quả khi gọi phương thức và kết quả kỳ vọng
        assertThat(appUserService.findAll()).isNotNull();
    }
    @Test
    @DisplayName("findAll can return list has 1 item")
    public void whenFindAll_thenReturnListHasOneItem(){
//        AAA
//        A: Arrange: chuẩn bị dữ liệu để gọi phương thức, dữ liệu đầu vào và kết quả kỳ vọng
//        AppUser appUser = new AppUser(1L, "KA", "12345", "ka@gmail.com");
//        List<AppUser> appUserList = Arrays.asList(appUser);
//        doReturn(appUserList).when(appUserRepo).findAll();
        int listSize = 1;
//        A: Action: gọi phương thức
        List<AppUser> appUserList1 = (List<AppUser>) appUserService.findAll();
//        A: Assert: so sánh kết quả khi gọi phương thức và kết quả kỳ vọng
        assertThat(appUserList1.size()).isEqualTo(listSize);
    }
    @Test
    @DisplayName("findById can return isPresent")
    public void whenFindById_thenReturnIsPresent(){
//        AAA
//        A: Arrange: chuẩn bị dữ liệu để gọi phương thức, dữ liệu đầu vào và kết quả kỳ vọng

//        A: Action: gọi phương thức
        Optional<AppUser> appUser = appUserService.findById(1L);
//        A: Assert: so sánh kết quả khi gọi phương thức và kết quả kỳ vọng
        assertThat(appUser.isPresent()).isTrue();
    }
    @Test
    @DisplayName("findById can return !isPresent")
    public void whenFindById2_thenReturnIsPresent(){
//        AAA
//        A: Arrange: chuẩn bị dữ liệu để gọi phương thức, dữ liệu đầu vào và kết quả kỳ vọng

//        A: Action: gọi phương thức
        Optional<AppUser> appUser = appUserService.findById(2L);
//        A: Assert: so sánh kết quả khi gọi phương thức và kết quả kỳ vọng
        assertThat(appUser.isPresent()).isFalse();
    }
    @Test
    @DisplayName("deleteById")
    public void whenDeleteById(){
//        AAA
//        A: Arrange: chuẩn bị dữ liệu để gọi phương thức, dữ liệu đầu vào và kết quả kỳ vọng

//        A: Action: gọi phương thức
        appUserRepo.deleteById(1L);
//        A: Assert: so sánh kết quả khi gọi phương thức và kết quả kỳ vọng
        verify(appUserRepo, times(1)).deleteById(1L);
    }

}