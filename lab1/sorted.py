import random
import time
from tqdm import tqdm

def sort(data, reverse=False):
  length = len(data)
  for n in range(length):
    maximum = n
    for i in range(n+1, length):
      if data[i] > data[maximum]:
        maximum = i
    z = data[maximum]
    data[maximum] = data[n]
    data[n] =  z
  if reverse:
    return data[::-1]
  return data


def sort2(data, reverse=False):
  for n in range(len(data)):
    maximum = max(data[n:])
    z = data[data.index(maximum)]
    data[data.index(maximum)] = data[n]
    data[n] =  z
  if reverse:
    return data[::-1]
  return data