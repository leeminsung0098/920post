package com.mycompany.hello.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page;             // ���� ������ ��ȣ
    private int recordSize;       // �������� ����� ������ ����
    private int pageSize;         // ȭ�� �ϴܿ� ����� ������ ������
    private String keyword;       // �˻� Ű����
    private String searchType;    // �˻� ����

    public SearchDto() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public int getOffset() {
        return (page - 1) * recordSize;
    }

}
