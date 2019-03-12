#Begin Imports
import sys
import math
#End Imports

#Begin Util Code
def log(x):
    print(x, file=sys.stderr)

class Player:
    def __init__(self):
        self.x = 0
        self.y = 0
        self.item = NONE
        self.order = None
        
class Tile:
    def __init__(self, x, y, name):
        self.x = x
        self.y = y
        self.name = name
        self.item = None

    def parse_name(self):
        return self.name.split("-")

    def __repr__(self):
        return "Tile: " + str(self.x) + ", " + str(self.y)

# Cells
BLUEBERRIES_CRATE = "B"
ICE_CREAM_CRATE = "I"
WINDOW = "W"
EMPTY_TABLE = "#"
DISHWASHER = "D"
FLOOR_CELL = "."
STRAWBERRY_CRATE = "S"
CHOPPING_BOARD = "C"
DOUGH = "H"
OVEN = "O"


# Items
NONE = "NONE"
DISH = "DISH"
ICE_CREAM = "ICE_CREAM"
BLUEBERRIES = "BLUEBERRIES"
STRAWBERRIES = "STRAWBERRIES"
CHOPPED_STRAWBERRIES = "CHOPPED_STRAWBERRIES"
CROISSANT = "CROISSANT"
class Game:
    def __init__(self):
        self.player = Player()
        self.partner = Player()
        self.tiles = []

    def addTile(self, x, y, tileChar):
        if tileChar != '.':
            self.tiles.append(Tile(x, y, tileChar))

    def getTileByName(self, name):
        for t in self.tiles:
            if t.name == name:
                return t

        #If tile not found
        log("Error: Tile not found in function getTileByName")

    def getTileByItem(self, item):
        for t in self.tiles:
            if t.item == item:
                return t

        #If tile not found
        log("Error: Tile not found in function getTileByItem")
    

    def getTileByCoords(self, x, y):
        for t in self.tiles:
            if t.x == x and t.y == y:
                return t

        #If tile not found
        log("Error: Tile not found in function getTileByCoords")

    def updatePlayer(self, x, y, item):
        self.player.x = x
        self.player.y = y
        self.player.item = item

    def updatePartner(self, x, y, item):
        self.partner.x = x
        self.partner.y = y
        self.partner.item = item

    def use(self, tile):
        print("USE", tile.x, tile.y,"; Python Starter AI")

    def move(self, tile):
        print("MOVE", tile.x, tile.y)
#End Util code

#Begin game code
game = Game()

# ALL CUSTOMERS INPUT: to ignore until bronze
num_all_customers = int(input())
for i in range(num_all_customers):
    # customer_item: the food the customer is waiting for
    # customer_award: the number of points awarded for delivering the food
    customer_item, customer_award = input().split()
    customer_award = int(customer_award)

# KITCHEN INPUT
for y in range(7):
    kitchen_line = input()
    for x, tileChar in enumerate(kitchen_line):
        game.addTile(x, y, tileChar)
        log(tileChar)
turns_Wait=0
# game loop


while True:
    turns_remaining = int(input())

    # PLAYERS INPUT
    #Gather and update player information
    player_x, player_y, player_item = input().split()
    player_x = int(player_x)
    player_y = int(player_y)
    game.updatePlayer(player_x, player_y, player_item)

    #Gather and update partner information
    partner_x, partner_y, partner_item = input().split()
    partner_x = int(partner_x)
    partner_y = int(partner_y)
    game.updatePartner(partner_x, partner_y, partner_item)

    #Gather and update table information
    for t in game.tiles:
        t.item = None
    num_tables_with_items = int(input())  # the number of tables in the kitchen that currently hold an item
    for i in range(num_tables_with_items):
        table_x, table_y, item = input().split()
        table_x = int(table_x)
        table_y = int(table_y)
        game.getTileByCoords(table_x, table_y).item = item

    # oven_contents: ignore until bronze league
    oven_contents, oven_timer = input().split()
    oven_timer = int(oven_timer)
    num_customers = int(input())  # the number of customers currently waiting for food

    orders = []
    for i in range(num_customers):
        customer_item, customer_award = input().split()
        customer_award = int(customer_award)
        orders.append((customer_award, customer_item))
    
    if game.player.order == None:
        orders.sort(reverse=True)

        for order in orders:
            if "CROISSANT" in order[1] & STRAWBERRIES in order[1]:
                continue
            game.player.order = order[1].replace("DISH","").split("-")
            log(order)
            break
    if game.player.order == None:
        print("WAIT")
    elif CROISSANT in game.player.order:
        if CROISSANT not in game.player.item and turns_Wait == 0:
            game.use(game.getTileByName(DOUGH))
        elif DOUGH in game.player.item and turns_Wait == 0 :
            game.use(game.getTileByName(OVEN))
            turns_Wait = 10
        elif turns_Wait != 0:
            turns_Wait -= 1
            print("WAIT")
        else:
            game.use(game.getTileByName(OVEN))
    elif CHOPPED_STRAWBERRIES in game.player.order:
            if STRAWBERRIES not in game.player.item:
                game.use(game.getTileByName(STRAWBERRY_CRATE))
            elif CHOPPED_STRAWBERRIES not in game.player.item:
                game.use(game.getTileByName(CHOPPING_BOARD))
            elif CHOPPED_STRAWBERRIES in game.player.item:
                game.use(game.getTileByName(DISHWASHER))
                game.player.order.remove(CHOPPED_STRAWBERRIES)
                
    elif ICE_CREAM in game.player.order:
            if DISH not in game.player.item:
                game.use(game.getTileByName(DISHWASHER))
            elif ICE_CREAM not in game.player.item:
                game.use(game.getTileByName(ICE_CREAM_CRATE))
            else:
                game.player.order.remove(ICE_CREAM)
                print("WAIT")
    elif BLUEBERRIES in game.player.order:
        if DISH not in game.player.item:
            game.use(game.getTileByName(DISHWASHER))
        elif BLUEBERRIES not in game.player.item:
            game.use(game.getTileByName(BLUEBERRIES_CRATE))
        else:
            game.player.order.remove(BLUEBERRIES)
            game.use(game.getTileByName(WINDOW))
    elif len(game.player.order) == 1 and DISH in game.player.item:
        game.use(game.getTileByName(WINDOW))
    elif DISH not in game.player.item:
        game.player.order = None
        print("WAIT")
    else:
        print("WAIT")
        log("ERROR")
        log(game.player.order)
        
#End game code