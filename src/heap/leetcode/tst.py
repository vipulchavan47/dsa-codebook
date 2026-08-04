import requests
from bs4 import BeautifulSoup


def print_secret_message(url):
    response = requests.get(url)
    response.raise_for_status()

    soup = BeautifulSoup(response.text, "html.parser")

    table = soup.find("table")
    rows = table.find_all("tr")[1:]  # Skip header

    points = []

    for row in rows:
        cols = [td.get_text(strip=True) for td in row.find_all("td")]
        if len(cols) != 3:
            continue

        x = int(cols[0])
        char = cols[1]
        y = int(cols[2])

        points.append((x, y, char))

    max_x = max(x for x, _, _ in points)
    max_y = max(y for _, y, _ in points)

    grid = [[" " for _ in range(max_x + 1)] for _ in range(max_y + 1)]

    for x, y, char in points:
        grid[y][x] = char

    # Print from top to bottom
    for y in range(max_y, -1, -1):
        print("".join(grid[y]))


# Input URL
url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub"

print_secret_message(url)