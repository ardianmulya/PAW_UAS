/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.dto;

/**
 *
 * @author M S I
 */
public class SearchFormData {

    private String keyword;
//constructor

    public SearchFormData() {
    }

    public SearchFormData(String keyword) {
        this.keyword = keyword;
    }
//getter

    public String getKeyword() {
        return this.keyword;
    }
//setter

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
