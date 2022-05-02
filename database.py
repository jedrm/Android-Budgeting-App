"""
Using Python to create a SQLite3 Database
"""

import sqlite3

# Some variables
DATABSE_NAME = "database.db"
conn = sqlite3.connect(DATABSE_NAME)
cur = conn.cursor()

# Date format: '2007-01-01 10:00:00'
cur.execute(
    """
    CREATE TABLE IF NOT EXISTS Transactions (
        TransactionID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
        Datetime DATETIME NOT NULL,
        Amount DOUBLE NOT NULL,
        MerchantName TEXT NOT NULL,
        Type TEXT NOT NULL
    )
    """
)