package com.backend.birdmeal.service;

import com.backend.birdmeal.dto.SellerDto;
import com.backend.birdmeal.dto.SellerUpdateDto;
import com.backend.birdmeal.entity.SellerEntity;
import com.backend.birdmeal.mapper.SellerMapper;
import com.backend.birdmeal.repository.SellerInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerInfoService {

    private final SellerInfoRepository sellerInfoRepository;
    
    // 판매자 정보 요청
    public SellerDto getSellerInfo(long sellerSeq){
        // db에서 찾기
        SellerEntity sellerEntity = sellerInfoRepository.findBySellerSeq(sellerSeq);

        // Entity -> Dto
        SellerDto sellerDto = SellerMapper.MAPPER.toDto(sellerEntity);

        return sellerDto;
    }


    // 판매자 정보 등록
    public boolean setSellerInfo(SellerDto sellerDto){
        // 판매자 정보가 없으면 false
        if(sellerDto == null) return false;

        // Dto -> Entity
        SellerEntity sellerEntity = SellerMapper.MAPPER.toEntity(sellerDto);

        // 저장하기
        sellerInfoRepository.save(sellerEntity);

        return true;
    }

    // 판매자 정보 수정
    public boolean updateSellerInfo(SellerUpdateDto sellerUpdateDto){
        // 판매자 정보가 없으면 false
        if(sellerUpdateDto == null) return false;

        // 먼저 SellerSeq로 Seller 정보 가져오기
        SellerEntity sellerEntity = sellerInfoRepository.findBySellerSeq(sellerUpdateDto.getSellerSeq());

        // update 해주기
        sellerEntity.setSellerNickname(sellerUpdateDto.getSellerNickname());
        sellerEntity.setSellerTel(sellerUpdateDto.getSellerTel());
        sellerEntity.setSellerAddress(sellerUpdateDto.getSellerAddress());
        sellerEntity.setSellerInfo(sellerUpdateDto.getSellerInfo());

        // Entity 저장하기
        sellerInfoRepository.save(sellerEntity);

        return true;
    }
}
