# High-Performance Hash Table – COSC310 Competition Winner 🥇
![cosc310-spring-2025-competition-abdul-rahman_page-0001](https://github.com/user-attachments/assets/22383bc1-069c-49c2-9e5d-7936def38c13)
This repository contains my winning submission among 92 students for the **COSC310 "Battle of Data Structures"** assignment, Spring 2025. The goal was to design and implement a **custom data structure optimized for performance** across a variety of operational workloads.

📌 **Award**: 1st Place   
📚 **Instructor**: Dr. Majid Khonji  
🏫 **Course**: COSC310 – Data Structures  
🎯 **Semester**: Spring 2025  
🧪 **Benchmark Basis**: Pure runtime speed across Insert, Search, and Delete scenarios.

---

## 🧠 Overview
I developed a custom **open-addressing hash table with linear probing**, written in Java and optimized for:
- Constant-time average insert/search/delete
- CPU cache locality
- Bit-level speed tricks (bit masking, no modulo)
- Zero object allocations

It outperformed all provided baseline structures and even beat Java's built-in `HashMap`.

---

## 🔍 Benchmark Scenarios
Each student’s implementation was tested against the following operation patterns:
| Scenario       | Description                             |
|----------------|---------------------------------------- |
| Insert-Heavy   | 50% insert, 25% search, 25% mixed ops   |
| Search-Heavy   | 70% search, 20% delete, 10% insert      |
| Delete-Heavy   | 60% delete, 25% search, 15% insert      |
| Balanced       | ~33% of each operation                  |
| **Scenario E** | Average of A–D (used to determine rank) |

---

## 🚀 Key Design Features

- ✅ **Fixed size table (32,768 slots)** — avoids costly resizing
- ✅ **Primitive `int[]` and `boolean[]`** — no boxing/unboxing
- ✅ **Custom high-quality hash function** — Murmur3-inspired
- ✅ **Linear probing with early exits**
- ✅ **Bit masking** for faster index calculations
- ✅ **Sentinel deletion** (`Integer.MIN_VALUE`)

---

## 📈 Performance Highlights

| Comparison              | My Avg. Time | Baseline       | Speedup        |
|-------------------------|--------------|----------------|-------------   |
| Java ArrayList          | 0.033 µs     | 17.477 µs      | **529×**       |
| Unsorted Linked List    | 0.033 µs     | 49.993 µs      | **1515×**      |
| Java HashMap            | 0.033 µs     | 0.054 µs       | **64% faster** |

---

## 📂 Repository Contents

```text
DS_100064692.java       ← Final implementation
DS_100064692.pdf        ← Short technical report (2 pages)
README.md               ← This file
```

---

## 🙌 Acknowledgments
Special thanks to Dr. Majid Khonji for designing a challenging and rewarding course.

## 🔗 Related
📄 LinkedIn Article – [🏆 Winning the "Battle of Data Structures" Competition](https://www.linkedin.com/pulse/winning-battle-data-structures-competition-abd-alrahman-ismaik-tzahe)

## 📫 Contact
Feel free to reach out on LinkedIn if you’d like to collaborate, ask questions, or discuss performance-driven data structure design!
