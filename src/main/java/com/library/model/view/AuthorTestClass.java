//package com.library.model.view;
//
//public class Author {
//
//    private String name;
//    private String address;
//    private int age;
//
//    private Author(String name, String address) {
//        this.name = name;
//        this.address = address;
//    }
//
//    public static void main(String[] args) {
//        Builder builder = Author.builder();
//        builder.address("Lviv");
//
//        Author author1 = builder.name("Vasa").build();
//        Author author2 = builder.name("Olesa").build();
//
//
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//        private String name;
//        private String address;
//        private int age;
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder address(String address) {
//            this.address = address;
//            return this;
//        }
//
//        public Author build() {
//            return new Author(name, address);
//        }
//    }
//}
