package controller;

import java.util.List;
import java.util.Scanner;

public class PhonebookController {
    private PhonebookDAO dao = new PhonebookDAO();
    private Scanner scanner = new Scanner(System.in);

    // 전화번호부 입력 처리
    public void inputPhonebook() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String hp = scanner.nextLine();
        System.out.print("Memo: ");
        String memo = scanner.nextLine();

        PhonebookVO vo = new PhonebookVO(id, name, hp, memo);
        dao.insertPhonebook(vo);
        System.out.println("입력이 완료되었습니다.");
    }

    // 전체 전화번호부 리스트 출력
    public void listAllPhonebooks() {
        List<PhonebookVO> list = dao.getAllPhonebooks();
        for (PhonebookVO vo : list) {
            System.out.println(vo);
        }
    }

    // 선택 전화번호부 출력
    public void getPhonebookById() {
        System.out.print("조회할 ID: ");
        int id = scanner.nextInt();
        PhonebookVO vo = dao.getPhonebookById(id);
        if (vo != null) {
            System.out.println(vo);
        } else {
            System.out.println("해당 ID를 가진 전화번호부가 없습니다.");
        }
    }

    // 검색 처리
    public void searchPhonebooks() {
        System.out.print("검색할 키워드: ");
        String keyword = scanner.nextLine();
        List<PhonebookVO> list = dao.searchPhonebooks(keyword);
        for (PhonebookVO vo : list) {
            System.out.println(vo);
        }
    }

    // 수정 처리
    public void updatePhonebook() {
        System.out.print("수정할 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("새로운 이름: ");
        String name = scanner.nextLine();
        System.out.print("새로운 전화번호: ");
        String hp = scanner.nextLine();
        System.out.print("새로운 메모: ");
        String memo = scanner.nextLine();

        PhonebookVO vo = new PhonebookVO(id, name, hp, memo);
        dao.updatePhonebook(vo);
        System.out.println("수정이 완료되었습니다.");
    }

    // 삭제 처리
    public void deletePhonebook() {
        System.out.print("삭제할 ID: ");
        int id = scanner.nextInt();
        dao.deletePhonebook(id);
        System.out.println("삭제가 완료되었습니다.");
    }

    // 메뉴 표시 및 입력 처리
    public void showMenu() {
        while (true) {
            System.out.println("전화번호부 프로그램");
            System.out.println("1. 전화번호부 입력");
            System.out.println("2. 전체 전화번호부 출력");
            System.out.println("3. 선택 전화번호부 출력");
            System.out.println("4. 전화번호부 검색");
            System.out.println("5. 전화번호부 수정");
            System.out.println("6. 전화번호부 삭제");
            System.out.println("7. 종료");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    inputPhonebook();
                    break;
                case 2:
                    listAllPhonebooks();
                    break;
                case 3:
                    getPhonebookById();
                    break;
                case 4:
                    searchPhonebooks();
                    break;
                case 5:
                    updatePhonebook();
                    break;
                case 6:
                    deletePhonebook();
                    break;
                case 7:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    public static void main(String[] args) {
        new PhonebookController().showMenu();
    }
}
