# This script gets books from adlibris and adds them to a database

import requests
from bs4 import BeautifulSoup
import mysql.connector

from Book import Book

url = "https://www.adlibris.com/se/kampanj/manadens-topplista"

def initialize_soup(url):
    sida = requests.get(url)
    soup = BeautifulSoup(sida.content, "html.parser")
    return soup


def get_books():
    books = soup.find_all("div", class_="product-panel__product product-panel__grid-cell")
    return books


def get_title(book):
    product_info = book.find("div", class_="product__info")
    product_info = product_info.find("a").get_text()
    product_info = product_info.split("\n\n\r\n")
    title = product_info[0].strip()
    return title

def get_author(book):
    product_info = book.find("div", class_="product__info")
    product_info = product_info.find("a").get_text()
    product_info = product_info.split("\n\n\r\n")
    if "," in product_info[1]:
        author = product_info[1].split(",")
        author[0] = author[0].strip()
        author[1] = author[1].strip()
        author = author[0] + ", " + author[1]
    else:
        author = product_info[1].strip()

    return author

def get_cover_img(book):
    cover_img = book.find("div", class_="product__image")
    cover_img = cover_img.find("div", class_="img").find("img")["src"]
    return cover_img


def get_price(book):
    price = book.find("div", class_="product__purchase").find("div", class_="price sek").get_text().strip()[:-3]
    return price

def get_x_books(x, books):
    book_class_list = []

    for i in range(len(books)):
        if x == i:
            break

        book = books[i]

        book_id = i
        title = get_title(book)
        author = get_author(book)
        cover_img = get_cover_img(book)
        price = get_price(book)

        print(i)
        print(cover_img)
        print(title)
        print(author)
        print(price)
        print("\n")

        book_class_list.append(Book(book_id, title, author, cover_img, price))

    return book_class_list

def add_books_to_database(books):
    mydb = mysql.connector.connect(
      host="localhost",
      user="mauritz",
      password="1234",
      database="Bookstore"
    )

    mycursor = mydb.cursor()

    # remove all rows from table first without deleting talbe
    delete_all_rows = "DELETE FROM books"
    mycursor.execute(delete_all_rows)
    mydb.commit()

    for i in range(len(books)):
        book = books[i]
        insert_books = "INSERT INTO books (id, title, author, coverImg, price) VALUES (%s, %s, %s, %s, %s)"
        values = (int(book.book_id), str(book.title), str(book.author), str(book.cover_img), float(book.price))

        mycursor.execute(insert_books, values)

        mydb.commit()



soup = initialize_soup(url)
books = get_books()
book_class_list = get_x_books(18, books)
add_books_to_database(book_class_list)
