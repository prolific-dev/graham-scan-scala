package com.prolificdev.grahamscan.controller

enum Status(status: String):
  def message: String = status

  case IDLE extends Status("IDLE")
  case SAVED extends Status("DATA SAVED")
  case LOADED extends Status("DATA LOADED")
  case CONVERTED extends Status("DATA CONVERTED")
  case CHANGED extends Status("DATA CHANGED")
  case CLEARED extends Status("DATA CLEARED")

end Status
